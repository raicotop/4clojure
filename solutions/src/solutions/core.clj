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
(def sol-34 (fn [x y] (take (- y x) (iterate inc x))))
(def sol-35 7)
(def sol-36 '[x 7
              y 3
              z 1])
(def sol-37 "ABC")
(def sol-38 (fn [& args]
              (->> args sort last)))
(def sol-39 #(mapcat vector %1 %2))
(def sol-40 (fn [separator sequence]
              (rest (interleave (repeat separator) sequence))))
(def sol-41 (fn [coll n]
              (->> (range (count coll))
                   (remove #(= 0 (rem (inc %) n)))
                   (map #(coll %)))))
(def sol-42 #(apply * (range 1 (inc %))))
(def sol-43
  (fn [coll n]
    (->> (range n)
         (map #(range % (count coll) n))
         (map #(map (fn [i] (nth coll i)) %)))))
(def sol-44 (fn [n coll]
              (->> (range (count coll))
                   (map #(mod (+ % n) (count coll)))
                   (map #(nth coll %)))))
(def sol-45 [1 4 7 10 13])
(def sol-46 #(fn [l r] (% r l)))
(def sol-47 4)
(def sol-48 6)
(def sol-49 (fn [n s] [(take n s) (drop n s)]))
(def sol-50 #(vals (group-by type %)))
(def sol-51 [1 2 3 4 5])
(def sol-52 '[c e])
(def sol-53 #(->> (range (dec (count %)))
                  (map (fn [i] [i (< (% i) (% (inc i)))]))
                  (partition-by second)
                  (filter (fn [x] (= true (second (first x)))))
                  (sort-by count >)
                  (first)
                  ((fn [l] (if (seq? l)
                             (->> [(first (first l)) (inc (inc (first (last l))))]
                                  (apply range)
                                  (map (fn [i] (% i))))
                             [])))))
(def sol-54 (fn [n xs]
              (->> (range (* (quot (count xs) n) n))
                   (partition-by #(quot % n))
                   (map #(map (fn [n] (nth xs n)) %)))))
(def sol-55 (fn [xs]
              (->> (group-by identity xs)
                   (map (fn [[k v]] {k (count v)}))
                   (apply conj))))
(def sol-56 #(reduce (fn [head x] (if ((set head) x) head (conj head x))) [] %))
(def sol-57 [5 4 3 2 1])
(def sol-58 (fn [& fs] (reduce (fn [f g] #(f (apply g %&))) fs)))
(def sol-59 (fn [& fs] (fn [& args] (map #(apply % args) fs))))
(def sol-60 (fn r
              ([f xs] (r f (first xs) (rest xs)))
              ([f v xs]
               (lazy-seq
                (cons v
                      (if (empty? xs) [] (r f (f v (first xs)) (rest xs))))))))
(def sol-61 #(apply hash-map (interleave %1 %2)))
(def sol-62 (fn r [f v]
              (lazy-seq
               (cons v (r f (f v))))))
(def sol-63 (fn [f s]
              (->> (map #(hash-map (f %) [%]) s)
                   (reduce #(merge-with into %1 %2)))))
(def sol-64 +)
(def sol-65 (fn [a]
              (let [base (empty a)]
                (cond
                  (= base {}) :map
                  (= base #{}) :set
                  (= base '()) (if (reversible? a) :vector :list)))))
(def sol-66 (fn gcd [a b]
              (cond
                (= a b) a
                (< a b) (gcd a (- b a))
                (> a b) (gcd (- a b) b))))
(def sol-67 (fn [n]
              (loop [x 3
                     acc [2]]
                (if (= n (count acc))
                  acc
                  (let [new-acc (if (not (empty? (filter #(= 0 (mod x %)) acc)))
                                  acc
                                  (conj acc x))]
                    (recur (inc x) new-acc))))))
(def sol-68 [7 6 5 4 3])
(def sol-69 (fn [f & ms]
              (reduce
               (fn [m1 m2]
                 (let [keys12 (clojure.set/intersection (set (keys m1)) (set (keys m2)))
                       keys1 (clojure.set/difference (set (keys m1)) keys12)
                       keys2 (clojure.set/difference (set (keys m2)) keys12)
                       vals12 (map #(f (m1 %) (m2 %)) keys12)
                       vals1 (map #(m1 %) keys1)
                       vals2 (map #(m2 %) keys2)]
                   (merge
                    (zipmap keys12 vals12)
                    (zipmap keys1 vals1)
                    (zipmap keys2 vals2))))
               ms)))
(def sol-70 #(sort-by clojure.string/upper-case (re-seq #"[A-Za-z]+" %)))
(def sol-71 last)
(def sol-72 #(reduce + %))
(def sol-73 (fn [[r0 r1 r2]]
              (->> [r0
                    r1
                    r2
                    [(nth r0 0) (nth r1 0) (nth r2 0)]
                    [(nth r0 1) (nth r1 1) (nth r2 1)]
                    [(nth r0 2) (nth r1 2) (nth r2 2)]
                    [(nth r0 0) (nth r1 1) (nth r2 2)]
                    [(nth r0 2) (nth r1 1) (nth r2 0)]]
                   (filter #(= (nth % 0) (nth % 1) (nth % 2)))
                   (remove #(= :e (first %)))
                   (ffirst))))
(def sol-74 (fn [xs]
              (->> (clojure.string/split xs #",")
                   (map #(Integer/parseInt %))
                   (filter #(= % (.intValue (Math/pow (.intValue (Math/sqrt %)) 2))))
                   (clojure.string/join ","))))
(def sol-75 (fn [n]
              (let [gcd (fn gcd [a b]
                          (cond
                            (= a b) a
                            (< a b) (gcd a (- b a))
                            (> a b) (gcd (- a b) b)))]
                (->> (range 1 (inc n))
                     (filter #(= 1 (gcd n %)))
                     (count)))))


(sol-75 40)

(range 1 2)