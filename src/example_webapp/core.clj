(ns example-webapp.core
  (:require [clojure.tools.nrepl.server :as nrepl]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.stacktrace :refer [wrap-stacktrace]]
            [compojure.handler :as handler]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [hiccup.page :refer [html5 include-css include-js]]
            [clojure.tools.logging :refer [trace debug info warn error fatal]])
  (:gen-class))

(defn index [request]
  (html5 [:html [:head [:title "The title"]
                 (include-css "/css/main.css")
                 (include-js "/js/main.js")]
          [:body [:div "The page"]]]))

(defroutes main-routes
  (GET "/" request (index request))
  (route/resources "/")
  (route/not-found "Page not found"))

(def app
  (-> #'main-routes
      (handler/api)
      (wrap-stacktrace)))

(defn -main [& args]
  (let [nrepl-port 4000
        jetty-port 3000]
    (info (format "start nrepl at port %s" nrepl-port))
    (nrepl/start-server :port nrepl-port)
    (info (format "start jetty at port %s" jetty-port))
    (jetty/run-jetty #'app {:port jetty-port :join? false})))
