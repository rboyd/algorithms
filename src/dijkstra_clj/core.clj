(ns dijkstra-clj.core)

(defn init-max [source m k]
  "Initialize with inf to each vertex"
  (merge m {k [(if (= k source) 0 Float/POSITIVE_INFINITY) source]}))

(defn min-vertex [[_ [a-weight _] :as a] [_ [b-weight _] :as b]]
  (if (> b-weight a-weight) a b))

(defn compare-graph [src-vert graph current-best distance]
  "For all edges originating from source vertex, update graph if distance + weight is new minimum."
  (apply merge current-best
    (for [[src dst weight] graph
          :let [total-distance (+ weight distance)
                current-distance (first (dst current-best))]
          :when (and (= src src-vert) (< total-distance current-distance))]
       { dst [total-distance src] })))

(defn dijkstra [graph source]
  "Given a graph and a source vertex, compute the shortest path to each vertex"
    (loop [current-best (reduce (partial init-max source) {} (map second graph))
           unvisited (set (keys current-best))]
      (if (empty? unvisited)
        current-best
        ; select the unvisited vertex with the minimum cost
        (let [current-pair (reduce min-vertex (select-keys current-best unvisited))
              vertex (first current-pair)
              distance (first (second current-pair))
              new-best (compare-graph vertex graph current-best distance)]
           ; subtract vertex from unvisited set
           (recur new-best (disj unvisited vertex))))))
