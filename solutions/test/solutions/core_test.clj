(ns solutions.core-test
   (:require [clojure.test :refer :all]
             [solutions.core :refer :all]))

(deftest testing-all-solutions
  (testing 1
    (is (= sol-1 true)))
  (testing 2
    (is (= (- 10 (* 2 3)) sol-2)))
  (testing 3
    (is (= sol-3 (.toUpperCase "hello world"))))
  (testing 4
    (is (= sol-4 '(:a :b :c))))
  (testing 5
    (is (= sol-5 (conj '(2 3 4) 1)))
    (is (= sol-5 (conj '(3 4) 2 1))))
  (testing 6
    (is (= sol-6 (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))))
  (testing 7
    (is (= sol-7 (conj [1 2 3] 4)))
    (is (= sol-7 (conj [1 2] 3 4))))
  (testing 8
    (is (= sol-8 (set '(:a :a :b :c :c :c :c :d :d))))
    (is (= sol-8 (clojure.set/union #{:a :b :c} #{:b :c :d}))))
  (testing 9
    (is (= #{1 2 3 4} (conj #{1 4 3} sol-9))))
  (testing 10
    (is (= sol-10 ((hash-map :a 10, :b 20, :c 30) :b)))
    (is (= sol-10 (:b {:a 10, :b 20, :c 30}))))
  (testing 11
    (is (= {:a 1, :b 2, :c 3} (conj {:a 1} sol-11 [:c 3]))))
  (testing 12
    (is (= sol-12 (first '(3 2 1))))
    (is (= sol-12 (second [2 3 4])))
    (is (= sol-12 (last (list 1 2 3)))))
  (testing 13
    (is (= sol-13 (rest [10 20 30 40]))))
  (testing 14
    (is (= sol-14 ((fn add-five [x] (+ x 5)) 3)))
    (is (= sol-14 ((fn [x] (+ x 5)) 3)))
    (is (= sol-14 (#(+ % 5) 3)))
    (is (= sol-14 ((partial + 5) 3))))
  (testing 15
    (is (= (sol-15 2) 4))
    (is (= (sol-15 3) 6))
    (is (= (sol-15 11) 22))
    (is (= (sol-15 7) 14)))
  (testing 16
    (is (= (sol-16 "Dave") "Hello, Dave!"))
    (is (= (sol-16 "Jenn") "Hello, Jenn!"))
    (is (= (sol-16 "Rhea") "Hello, Rhea!")))
  (testing 17
    (is (= sol-17 (map #(+ % 5) '(1 2 3)))))
  (testing 18
    (is (= sol-18 (filter #(> % 5) '(3 4 5 6 7)))))
  (testing 19
    (is (= (sol-19 [1 2 3 4 5]) 5))
    (is (= (sol-19 '(5 4 3)) 3))
    (is (= (sol-19 ["b" "c" "d"]) "d")))
  (testing 20
    (is (= (sol-20 (list 1 2 3 4 5)) 4))
    (is (= (sol-20 ["a" "b" "c"]) "b"))
    (is (= (sol-20 [[1 2] [3 4]]) [1 2])))
  (testing 21
    (is (= (sol-21 '(4 5 6 7) 2) 6))
    (is (= (sol-21 [:a :b :c] 0) :a))
    (is (= (sol-21 [1 2 3 4] 1) 2))
    (is (= (sol-21 '([1 2] [3 4] [5 6]) 2) [5 6])))
  (testing 22
    (is (= (sol-22 '(1 2 3 3 1)) 5))
    (is (= (sol-22 "Hello World") 11))
    (is (= (sol-22 [[1 2] [3 4] [5 6]]) 3))
    (is (= (sol-22 '(13)) 1))
    (is (= (sol-22 '(:a :b :c)) 3)))
  (testing 23
    (is (= (sol-23 [1 2 3 4 5]) [5 4 3 2 1]))
    (is (= (sol-23 (sorted-set 5 7 2 7)) '(7 5 2)))
    (is (= (sol-23 [[1 2] [3 4] [5 6]]) [[5 6] [3 4] [1 2]])))
  (testing 24
    (is (= (sol-24 [1 2 3]) 6))
    (is (= (sol-24 (list 0 -2 5 5)) 8))
    (is (= (sol-24 #{4 2 1}) 7))
    (is (= (sol-24 '(0 0 -1)) -1))
    (is (= (sol-24 '(1 10 3)) 14)))
  (testing 25
    (is (= (sol-25 #{1 2 3 4 5}) '(1 3 5)))
    (is (= (sol-25 [4 2 1 6]) '(1)))
    (is (= (sol-25 [2 2 4 6]) '()))
    (is (= (sol-25 [1 1 1 3]) '(1 1 1 3))))
  (testing 26
    (is (= (sol-26 3) '(1 1 2)))
    (is (= (sol-26 6) '(1 1 2 3 5 8)))
    (is (= (sol-26 8) '(1 1 2 3 5 8 13 21))))
  (testing 27
    (is (false? (sol-27 '(1 2 3 4 5))))
    (is (true? (sol-27 "racecar")))
    (is (true? (sol-27 [:foo :bar :foo])))
    (is (true? (sol-27 '(1 1 3 3 1 1))))
    (is (false? (sol-27 '(:a :b :c)))))
  (testing 28
    (is (= (sol-28 '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6)))
    (is (= (sol-28 ["a" ["b"] "c"]) '("a" "b" "c")))
    (is (= (sol-28 '((((:a))))) '(:a))))
  (testing 29
    (is (= (sol-29 "HeLlO, WoRlD!") "HLOWRD"))
    (is (empty? (sol-29 "nothing")))
    (is (= (sol-29 "$#A(*&987Zf") "AZ")))
  (testing 30
    (is (= (apply str (sol-30 "Leeeeeerrroyyy")) "Leroy"))
    (is (= (sol-30 [1 1 2 3 3 2 2 3]) '(1 2 3 2 3)))
    (is (= (sol-30 [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))))
  (testing 31
    (is (= (sol-31 [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3))))
    (is (= (sol-31 [:a :a :b :b :c]) '((:a :a) (:b :b) (:c))))
    (is (= (sol-31 [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))))
  (testing 32
    (is (= (sol-32 [1 2 3]) '(1 1 2 2 3 3)))
    (is (= (sol-32 [:a :a :b :b]) '(:a :a :a :a :b :b :b :b)))
    (is (= (sol-32 [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])))
    (is (= (sol-32 [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))))
  (testing 33
    (is (= (sol-33 [1 2 3] 2) '(1 1 2 2 3 3)))
    (is (= (sol-33 [:a :b] 4) '(:a :a :a :a :b :b :b :b)))
    (is (= (sol-33 [4 5 6] 1) '(4 5 6)))
    (is (= (sol-33 [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4])))
    (is (= (sol-33 [44 33] 2) [44 44 33 33])))
  (testing 34
    (is (= (sol-34 1 4) '(1 2 3)))
    (is (= (sol-34 -2 2) '(-2 -1 0 1)))
    (is (= (sol-34 5 8) '(5 6 7))))
  (testing 35
    (is (= sol-35 (let [x 5] (+ 2 x))))
    (is (= sol-35 (let [x 3, y 10] (- y x))))
    (is (= sol-35 (let [x 21] (let [y 3] (/ x y))))))
  (testing 36
    (let [sol (apply hash-map sol-36)]
     (is (= 10 (let [x (sol 'x) y (sol 'y) z (sol 'z)] (+ x y))))
     (is (= 4 (let [x (sol 'x) y (sol 'y) z (sol 'z)] (+ y z))))
     (is (= 1 (let [x (sol 'x) y (sol 'y) z (sol 'z)] z)))))
  (testing 37
    (is (= sol-37 (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))))
  (testing 38
    (is (= (sol-38 1 8 3 4) 8))
    (is (= (sol-38 30 20) 30))
    (is (= (sol-38 45 67 11) 67)))
  (testing 39
    (is (= (sol-39 [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c)))
    (is (= (sol-39 [1 2] [3 4 5 6]) '(1 3 2 4)))
    (is (= (sol-39 [1 2 3 4] [5]) [1 5]))
    (is (= (sol-39 [30 20] [25 15]) [30 25 20 15])))
  (testing 40
    (is (= (sol-40 0 [1 2 3]) [1 0 2 0 3]))
    (is (= (apply str (sol-40 ", " ["one" "two" "three"])) "one, two, three"))
    (is (= (sol-40 :z [:a :b :c :d]) [:a :z :b :z :c :z :d])))
  (testing 41 
    (is (= (sol-41 [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8]))
    (is (= (sol-41 [:a :b :c :d :e :f] 2) [:a :c :e]))
    (is (= (sol-41 [1 2 3 4 5 6] 4) [1 2 3 5 6])))
  (testing 42
    (is (= (sol-42 1) 1))
    (is (= (sol-42 3) 6))
    (is (= (sol-42 5) 120))
    (is (= (sol-42 8) 40320)))
  (testing 43
    (is (= (sol-43 [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6))))
    (is (= (sol-43 (range 9) 3) '((0 3 6) (1 4 7) (2 5 8))))
    (is (= (sol-43 (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))))
  (testing 44
    (is (= (sol-44 2 [1 2 3 4 5]) '(3 4 5 1 2)))
    (is (= (sol-44 -2 [1 2 3 4 5]) '(4 5 1 2 3)))
    (is (= (sol-44 6 [1 2 3 4 5]) '(2 3 4 5 1)))
    (is (= (sol-44 1 '(:a :b :c)) '(:b :c :a)))
    (is (= (sol-44 -4 '(:a :b :c)) '(:c :a :b))))
  (testing 45
    (is (= sol-45 (take 5 (iterate #(+ 3 %) 1)))))
  (testing 46
    (is (= 3 ((sol-46 nth) 2 [1 2 3 4 5])))
    (is (= true ((sol-46 >) 7 8)))
    (is (= 4 ((sol-46 quot) 2 8)))
    (is (= [1 2 3] ((sol-46 take) [1 2 3 4 5] 3))))
  (testing 47
    (is (contains? #{4 5 6} sol-47))
    (is (contains? [1 1 1 1 1] sol-47))
    (is (contains? {4 :a 2 :b} sol-47))
    (is (not (contains? [1 2 4] sol-47))))
  (testing 48
    (is (= sol-48 (some #{2 7 6} [5 6 7 8])))
    (is (= sol-48 (some #(when (even? %) %) [5 6 7 8]))))
  (testing 49
    (is (= (sol-49 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]]))
    (is (= (sol-49 1 [:a :b :c :d]) [[:a] [:b :c :d]]))
    (is (= (sol-49 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])))
  (testing 50
    (is (= (set (sol-50 [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]}))
    (is (= (set (sol-50 [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]}))
    (is (= (set (sol-50 [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})))
  (testing 51
    (is (= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] sol-51] [a b c d]))))
  (testing 52
    (is (= [2 4] (let [[a b c d e] [0 1 2 3 4]] [c e]))))
  (testing 53
    (is (= (sol-53 [1 0 1 2 3 0 4 5]) [0 1 2 3]))
    (is (= (sol-53 [5 6 1 3 2 7]) [5 6]))
    (is (= (sol-53 [2 3 3 4 5]) [3 4 5]))
    (is (= (sol-53 [7 6 5 4]) [])))
  (testing 54
    (is (= (sol-54 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8))))
    (is (= (sol-54 2 (range 8)) '((0 1) (2 3) (4 5) (6 7))))
    (is (= (sol-54 3 (range 8)) '((0 1 2) (3 4 5)))))
  (testing 55
    (is (= (sol-55 [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1}))
    (is (= (sol-55 [:b :a :b :a :b]) {:a 2, :b 3}))
    (is (= (sol-55 '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2})))
  (testing 56
    (is (= (sol-56 [1 2 1 3 1 2 4]) [1 2 3 4]))
    (is (= (sol-56 [:a :a :b :b :c :c]) [:a :b :c]))
    (is (= (sol-56 '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3])))
    (is (= (sol-56 (range 50)) (range 50))))
  (testing 57
    (is (= sol-57 ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5))))
  (testing 58
    (is (= [3 2 1] ((sol-58 rest reverse) [1 2 3 4])))
    (is (= 5 ((sol-58 (partial + 3) second) [1 2 3 4])))
    (is (= true ((sol-58 zero? #(mod % 8) +) 3 5 7 9)))
    (is (= "HELLO" ((sol-58 #(.toUpperCase %) #(apply str %) take) 5 "hello world"))))
  (testing 59
    (is (= [21 6 1] ((sol-59 + max min) 2 3 5 1 6 4)))
    (is (= ["HELLO" 5] ((sol-59 #(.toUpperCase %) count) "hello")))
    (is (= [2 6 4] ((sol-59 :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))))
  (testing 60
    (is (= (take 5 (sol-60 + (range))) [0 1 3 6 10]))
    (is (= (sol-60 conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]]))
    (is (= (last (sol-60 * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)))
  (testing 61
    (is (= (sol-61 [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3}))
    (is (= (sol-61 [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"}))
    (is (= (sol-61 [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"})))
  (testing 62
    (is (= (take 5 (sol-62 #(* 2 %) 1)) [1 2 4 8 16]))
    (is (= (take 100 (sol-62 inc 0)) (take 100 (range))))
    (is (= (take 9 (sol-62 #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3])))))
  (testing 63
    (is (= (sol-63 #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]}))
    (is (= (sol-63 #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
           {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]}))
    (is (= (sol-63 count [[1] [1 2] [3] [1 2 3] [2 3]])
           {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})))
  (testing 64
    (is (= 15 (reduce sol-64 [1 2 3 4 5])))
    (is (=  0 (reduce sol-64 [])))
    (is (=  6 (reduce sol-64 1 [2 3]))))
  (testing 65
    (is (= :map (sol-65 {:a 1, :b 2})))
    (is (= :list (sol-65 (range (rand-int 20)))))
    (is (= :vector (sol-65 [1 2 3 4 5 6])))
    (is (= :set (sol-65 #{10 (rand-int 5)})))
    (is (= [:map :set :vector :list] (map sol-65 [{} #{} [] ()]))))
  (testing 66
    (is (= (sol-66 2 4) 2))
    (is (= (sol-66 10 5) 5))
    (is (= (sol-66 5 7) 1))
    (is (= (sol-66 1023 858) 33)))
  (testing 67
    (is (= (sol-67 2) [2 3]))
    (is (= (sol-67 5) [2 3 5 7 11]))
    (is (= (last (sol-67 100)) 541)))
  (testing 68
    (is (= sol-68
           (loop [x 5
                  result []]
             (if (> x 0)
               (recur (dec x) (conj result (+ 2 x)))
               result)))))
  (testing 69
    (is (= (sol-69 * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5})
           {:a 4, :b 6, :c 20}))
    (is (= (sol-69 - {1 10, 2 20} {1 3, 2 10, 3 15})
           {1 7, 2 10, 3 15}))
    (is (= (sol-69 concat {:a [3], :b [6]} {:a [4 5], :c [8 9]} {:b [7]})
           {:a [3 4 5], :b [6 7], :c [8 9]})))
  (testing 70
    (is (= (sol-70  "Have a nice day.")
           ["a" "day" "Have" "nice"]))
    (is (= (sol-70  "Clojure is a fun language!")
           ["a" "Clojure" "fun" "is" "language"]))
    (is (= (sol-70  "Fools fall for foolish follies.")
           ["fall" "follies" "foolish" "Fools" "for"]))))
 
(comment 
  (do
    (use 'solutions.core :reload)
    (use 'solutions.core-test :reload)
    (run-tests)))





   
