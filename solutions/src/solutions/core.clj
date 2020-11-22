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
(def sol-76 [1 3 5 7 9 11])
(def sol-77 (fn [words]
              (->> (map #(hash-map (frequencies %) #{%}) words)
                   (reduce #(merge-with into %1 %2))
                   (map second)
                   (filter #(< 1 (count %)))
                   (set))))
(def sol-78 (fn [f & args]
              (loop [f #(apply f args)]
                (if (fn? f)
                  (recur (f))
                  f))))
(def sol-79 (fn [rows]
              (let [gen-paths (fn [n]
                                (loop [acc [[{0 0}]]]
                                  (if (= n (count (first acc)))
                                    acc
                                    (recur (->> (map #(vector
                                                       (conj % (hash-map
                                                                (inc (ffirst (last %)))
                                                                (second (first (last %)))))
                                                       (conj % (hash-map
                                                                (inc (ffirst (last %)))
                                                                (inc (second (first (last %)))))))
                                                     acc)
                                                (reduce into))))))]

                (->> (gen-paths (count rows))
                     (map (fn [path]
                            (map (fn [point]
                                   (nth (nth rows (ffirst point)) (second (first point))))
                                 path)))
                     (map #(apply + %))
                     (apply min)))))
(def sol-80 (fn [n]
              (->> (range 1 n)
                   (filter #(= 0 (mod n %)))
                   (reduce +)
                   (= n))))
(def sol-81 (comp set filter))
(def sol-82 (fn [words]
              (let [permutations (fn permutations [s]
                                   (lazy-seq
                                    (if (seq (rest s))
                                      (apply concat (for [x s]
                                                      (map #(cons x %) (permutations (remove #{x} s)))))
                                      [s])))
                    similar? (fn [x y]
                               (if (= (count x) (count y))
                                 (>= 1 (->> (range (count x))
                                            (remove #(= (nth x %) (nth y %)))
                                            (count)))
                                 (if (#{-1 1} (- (count x) (count y)))
                                   (let [s (if (> (count x) (count y)) y x)
                                         l (if (> (count x) (count y)) x y)]
                                     (< 0 (->> (range (count l))
                                               (map #(str (subs l 0 %) (subs l (inc %) (count l))))
                                               (filter #(= s %))
                                               (count))))
                                   false)))]
                (->> (permutations words)
                     (map #(->> (range (dec (count %)))
                                (map (fn [n] (similar? (nth % n) (nth % (inc n)))))))
                     (map #(reduce (fn [x y] (and x y)) %))
                     (filter #(= % true))
                     (empty?)
                     not))))
(def sol-83 (fn [& bools] (= #{false true} (set bools))))
(def sol-84 (fn [rels]
              (let [add-transitive (fn add-transitive [m]
                                     (->> (keys m)
                                          (map #(hash-map % (->> (m %)
                                                                 (map (fn [val] (m val)))
                                                                 (reduce into))))
                                          (reduce merge)
                                          (merge-with into m)
                                          ((fn [new-m]
                                             (if (not= m new-m)
                                               (add-transitive new-m)
                                               new-m)))))]
                (->> (map #(hash-map (first %) #{(second %)}) rels)
                     (reduce #(merge-with into %1 %2))
                     (add-transitive)
                     (map #(->> (second %)
                                (map (fn [val] [(first %) val]))))
                     (reduce into)
                     (set)))))
(def sol-85 (fn powerset [s]
              (reduce #(into %
                             (for [subset %]
                               (conj subset %2)))
                      #{#{}}
                      s)))
(def sol-86 (fn [n]
              (letfn [(nxt [x]
                        (->> (str x)
                             (map str)
                             (map #(Integer/parseInt %))
                             (map #(* % %))
                             (reduce +)))]
                (loop [x n
                       acc #{}]
                  (if (contains? acc x)
                    (= 1 x)
                    (recur (nxt x) (conj acc x)))))))
(def sol-88 (fn [x y]
              (clojure.set/difference
               (clojure.set/union x y)
               (clojure.set/intersection x y))))
(def sol-89' (fn [xs]
               (let [permutations (fn permutations [s]
                                    (lazy-seq
                                     (if (seq (rest s))
                                       (apply concat (for [x s]
                                                       (map #(cons x %) (permutations (remove #{x} s)))))
                                       [s])))
                     vs (set (flatten xs))
                     es (->> (map reverse xs)
                             (concat xs)
                             (set))]
                 (->> (permutations vs)
                      (map #(interleave % %))
                      (map #(drop 1 %))
                      (map #(conj (vec %) (first %)))
                      (map #(partition 2 %))
                      (map (fn [path] (map #(contains? es %) path)))
                      (map #(reduce (fn [a b] (and a b)) %))
                      (reduce #(or %1 %2))))))
(def sol-89 (fn [xs]
              (loop [res []
                     stack (map #(vector res %) (apply conj '() xs))
                     remain xs]
                (cond
                  (= (count xs) (count res)) true
                  (empty? stack) false
                  (= res (first (first stack))) (let [e (second (first stack))
                                                      e-directed (if (= (first e) (second (last res)))
                                                                   e
                                                                   (reverse e))
                                                      remove-once (fn [pred coll]
                                                                    ((fn inner [coll]
                                                                       (lazy-seq
                                                                        (when-let [[x & xs] (seq coll)]
                                                                          (if (pred x)
                                                                            xs
                                                                            (cons x (inner xs))))))
                                                                     coll))
                                                      new-res (conj res e-directed)
                                                      new-remain (remove-once (set [e (reverse e)]) remain)
                                                      next-edges (fn [e es res]
                                                                   (->> (filter #(or (= (last e) (first %))
                                                                                     (= (last e) (second %))) es)
                                                                        (map #(vector res %))))
                                                      new-stack (let [next-es (next-edges e-directed new-remain new-res)]
                                                                  (if (empty? next-es)
                                                                    (rest stack)
                                                                    (apply conj (rest stack) (next-edges e-directed new-remain new-res))))]
                                                  (recur new-res new-stack new-remain))
                  :else (recur (vec (drop-last res)) stack (conj remain (last res)))))))
(def sol-90 (fn [a b]
              (set (for [x a
                         y b]
                     [x y]))))
(def sol-91 (fn [edges]
              (loop [discovered-vertives (set (first edges))
                     rst (rest edges)]
                (let [new-discovered-edges (filter #(or (contains? discovered-vertives (first %))
                                                        (contains? discovered-vertives (second %))) rst)
                      new-discovered-vertives (-> new-discovered-edges flatten set)
                      new-rst (remove (set new-discovered-edges) rst)]
                  (cond
                    (empty? new-rst) true
                    (empty? new-discovered-edges) false
                    :else (recur new-discovered-vertives new-rst))))))
(def sol-92 (fn [s]
              (let [values {"I" 1
                            "IV" 4
                            "V" 5
                            "IX" 9
                            "X" 10
                            "XL" 40
                            "L" 50
                            "XC" 90
                            "C" 100
                            "CD" 400
                            "D" 500
                            "CM" 900
                            "M" 1000}]
                (loop [acc 0
                       rst s]
                  (if (empty? rst)
                    acc
                    (let [p (apply str (take 2 rst))
                          interpreted-part (if (contains? values p) p (str (first p)))]
                      (recur (+ acc (values interpreted-part)) 
                             (drop (count interpreted-part) rst))))))))










































