(defproject com.luposlip/domina "1.0.4"
  :description "A DOM manipulation library for ClojureScript inspired by JQuery"
  :source-paths ["src"]
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [org.clojure/clojurescript "1.10.879"]]
  :plugins [[lein-cljsbuild "1.1.8"]
            [lein-clojars "0.9.1"]]
  :hooks [leiningen.cljsbuild]
  :cljsbuild {:builds [{:id "development"
                        :source-paths ["src"]
                        :compiler {:optimizations :none
                                   ;;:source-map "public/javascripts_dev/main.js.map"
                                   :source-map true
                                   :output-dir "public/javascripts_dev"
                                   :output-to "public/javascripts_dev/domina.js"}}
                       #_{:jar true
                        :compiler {:libs ["goog/dom/query.js"]
                                   :pretty-print true
                                   :output-dir ".cljsbuild/domina"
                                   :output-to "public/domina.js"}}
                       #_{:source-paths ["test/cljs"]
                        :compiler  {:libs ["goog/dom/query.js"]
                                    :pretty-print true
                                    :optimizations :none
                                    :output-dir "public/build_no_opt"
                                    :output-to "public/test_no_opt.js"}}
                       #_{:source-paths ["test/cljs"]
                        :compiler  {:libs ["goog/dom/query.js"]
                                    :optimizations :whitespace
                                    :pretty-print true
                                    :output-dir ".cljsbuild/whitespace"
                                    :output-to "public/test_whitespace.js"}}
                       #_{:source-paths ["test/cljs"]
                        :compiler  {:libs ["goog/dom/query.js"]
                                    :optimizations :simple
                                    :pretty-print true
                                    :output-dir ".cljsbuild/simple"
                                    :output-to "public/test_simple.js"}}
                       #_{:source-paths ["test/cljs"]
                        :compiler  {:libs ["goog/dom/query.js"]
                                    :optimizations :advanced
                                    :pretty-print true
                                    :output-dir ".cljsbuild/advanced"
                                    :output-to "public/test_advanced.js"}}]})
