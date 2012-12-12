(ns dijkstra-clj.core-test
  (:use clojure.test
        dijkstra-clj.core))

; test graph taken from wikipedia (see for visual)
; http://en.wikipedia.org/wiki/Dijkstra's_algorithm
(def test-graph
  [[:a :b 7]
   [:a :c 9]
   [:a :f 14]
   [:b :a 7]
   [:b :c 10]
   [:b :d 15]
   [:c :a 9]
   [:c :b 10]
   [:c :d 11]
   [:c :f 2]
   [:d :b 15]
   [:d :c 11]
   [:d :e 6]
   [:e :d 6]
   [:e :f 9]
   [:f :a 14]
   [:f :c 2]
   [:f :e 9]])

(def a-paths
  { :a [0 :a]
    :b [7 :a]
    :c [9 :a]
    :d [20 :c]
    :e [20 :f]
    :f [11 :c] })

(deftest paths-from-a-test
  (testing "shortest paths from a"
    (is (= a-paths (dijkstra-clj.core/dijkstra test-graph :a)))))

(def a-paths-step2
  { :a [0 :a]
    :b [7 :a]
    :c [9 :a]
    :d [Float/POSITIVE_INFINITY :a]
    :e [Float/POSITIVE_INFINITY :a]
    :f [14 :a] })

(def a-paths-step3
  { :a [0 :a]
    :b [7 :a]
    :c [9 :a]
    :d [22 :b]
    :e [Float/POSITIVE_INFINITY :a]
    :f [14 :a] })

(deftest compare-graph-test
  (testing "finds new shortest paths exposed via b"
    (is (= a-paths-step3 (compare-graph :b test-graph a-paths-step2 7)))))
