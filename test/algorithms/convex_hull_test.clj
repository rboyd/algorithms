(ns algorithms.convex-hull-test
  (:use clojure.test
        algorithms.convex-hull))

(deftest ccw-test
  (testing "counter-clockwise turn"
    (let [p1 [4 4]
          p2 [6 6]
          p3 [4 5]]
      (is (> (ccw p1 p2 p3) 0))))
  (testing "collinear"
    (let [p1 [3 3]
          p2 [2 2]
          p3 [1 1]]
      (is (= (ccw p1 p2 p3) 0))))
  (testing "clockwise turn"
    (let [p1 [4 4       ]
          p2 [6 6]
          p3 [5 4]]
      (is (< (ccw p1 p2 p3) 0)))))
          
