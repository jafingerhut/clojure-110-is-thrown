(ns clojure-110-is-thrown.core-test
  (:require [clojure.test :refer :all]
            [clojure-110-is-thrown.core :refer :all]))

(defn min-clojure-version [min-version-vector]
  (>= (compare ((juxt :major :minor) *clojure-version*)
               min-version-vector)
      0))

(deftest test1
  (println "*clojure-version* is: " *clojure-version*)
  (let [vec1 [:a :b :c]]
    (is (thrown? IndexOutOfBoundsException
                 (vec1 3)))
    (let [expected-error-msg-regex
          (if (min-clojure-version [1 10])
            #"Wrong number of args \(2\) passed to: clojure.lang.PersistentVector"
            #"Wrong number of args \(2\) passed to: PersistentVector")]
      (is (thrown-with-msg? clojure.lang.ArityException
                            expected-error-msg-regex
                            (vec1 3 :not-found))))))
