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
