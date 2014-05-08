(defproject example-webapp "0.1.0-SNAPSHOT"
  :description "Example webapp"
  :url ""
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main example-webapp.core
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/tools.logging "0.2.6"]
                 [log4j/log4j "1.2.17"]
                 [ring "1.2.2"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.5"]])
