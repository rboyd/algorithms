(ns algorithms.convex-hull)

(defn ccw
  "Three points are counter-clockwise turn if ccw > 0,
  clockwise if ccw < 0, and collinear if ccw = 0 because
  ccw is a determinant that gives the signed area of the
  triangle formed by p1, p2 and p3. [Wikipedia]"
  [[p1x p1y] [p2x p2y] [p3x p3y]]
  (- (* (- p2x p1x)
        (- p3y p1y))
     (* (- p2y p1y)
        (- p3x p1x))))

(defn lowest-y
  [& points]
  (apply min-key #(second %) points))

(defn polar-sort
  [[anchor-x anchor-y] & points]
  (sort-by (fn [[x y]] (Math/atan2 (- y anchor-y) (- x anchor-x))) points))
  
(defn graham-scan
  "Applies the Graham scan algorithm to find the convex
  hull from a sequence of points in O(n lg n)."
  [& points]
  (let [anchor       (apply lowest-y points)
        polar-sorted (->> (remove #(= anchor %) points)
                          (apply polar-sort anchor))]
    (loop [acc    [(first polar-sorted) anchor]
           unproc (rest polar-sorted)]
      (let [[p2 p1]     (take 2 acc)
            [p3 & next] unproc
            left-turn?  (pos? (ccw p1 p2 p3))
            new-acc     (if left-turn? (cons p3 acc) (cons p3 (rest acc)))]
        (if (= p3 anchor)
          (rest new-acc)
          (if (empty? next)
            (recur new-acc [anchor])
            (recur new-acc next)))))))
