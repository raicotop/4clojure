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
    (is (= (sol-39 [30 20] [25 15]) [30 25 20 15]))))
 
(comment 
  (do
    (use 'solutions.core :reload)
    (use 'solutions.core-test :reload)
    (run-tests)))





   
