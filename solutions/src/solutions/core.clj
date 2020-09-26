(ns solutions.core)

(def sol-1 true)
(def sol-2 4)
(def sol-3 "HELLO WORLD")
(def sol-4 (list :a :b :c))
(def sol-5 (list 1 2 3 4))
(def sol-6 [:a :b :c])
(def sol-7 [1 2 3 4])
(def sol-8 #{:a :b :c :d})
(def sol-9 2)
(def sol-10 20)
(def sol-11 {:b 2})
(def sol-12 3)
(def sol-13 [20 30 40])
(def sol-14 8)
(def sol-15 #(* 2 %))
(def sol-16 #(str "Hello, " % \!))
(def sol-17 [6 7 8])
(def sol-18 [6 7])
(def sol-19 #(-> % reverse first))
(def sol-20 #(nth % (- (count %) 2)))
(def sol-21 #(first (drop %2 %1)))
(def sol-22 #(reduce + (map (fn [_] 1) %)))
(def sol-23 #(into '() %))
(def sol-24 #(reduce + %))
(def sol-25 #(filter odd? %))
(def sol-26 (fn fib
              [n]
              (cond
                (= n 1) [1]
                (= n 2) [1 1]
                :else (let [prev (fib (dec n))]
                        (conj prev (reduce + (take 2 (reverse prev))))))))
(def sol-27 #(= (seq %) (reverse %)))
(def sol-28 (fn flatten
              [s]
              (if (coll? s)
                (mapcat flatten s)
                [s])))
(def sol-29 #(apply str (re-seq #"[A-Z]" %)))
(def sol-30 #(->> %
                  (partition-by identity)
                  (map first)))
(def sol-31 #(partition-by identity %))
(def sol-32 #(interleave % %))
(def sol-33 #(mapcat (partial repeat %2) %1))
(def sol-34 #())