(ns clojure-110-is-thrown.core-test
  (:require [clojure.test :refer :all]
            [clojure-110-is-thrown.core :refer :all]))

(deftest test1
  (println "*clojure-version* is: " *clojure-version*)
  (let [vec1 [:a :b :c]]
    (is (thrown? IndexOutOfBoundsException
                 (vec1 3)))
    (is (thrown-with-msg? clojure.lang.ArityException
                          #"Wrong number of args \(2\) passed to: (clojure\.lang\.)?PersistentVector"
                          (vec1 3 :not-found)))))
