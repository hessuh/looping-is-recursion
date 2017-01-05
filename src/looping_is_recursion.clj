(ns looping-is-recursion)

(defn power [base exp]
  (let [helper (fn [acc base n]
                 (if (zero? n)
                   acc
                   (recur (* acc base) base (dec n))))]
    (helper 1 base exp)))

(defn last-element [a-seq]
  (if-not (seq a-seq) nil
    (let [helper (fn [n a-seq]
                   (if (= 1 n)
                     (first a-seq)
                     (recur (dec n) (rest a-seq))))]
      (helper (count a-seq) a-seq))))


(defn seq= [seq1 seq2]
  (if-not
    (= (count seq1)
       (count seq2))
    false
    (let [helper (fn [s1 s2]
                   (if (empty? s1)
                     true
                     (if-not
                       (= (first s2)
                          (first s1))
                       false
                       (recur (rest s1) (rest s2)))))]

      (helper seq1 seq2))))


(defn find-first-index [pred a-seq]
  (loop [n (count a-seq)
         as a-seq]
    (cond
      (zero? n)
      nil
      (pred (first as))
      (- (count a-seq) n)
      :else
      (recur (dec n) (rest as)))))

(defn avg [a-seq]
  (loop [sum 0
         as a-seq]
    (cond
      (empty? as)
      (/ sum (count a-seq))
      :else
      (recur (+ sum (first as)) (rest as)))))

(defn parity [a-seq]
  ":(")

(defn fast-fibo [n]
  ":(")

(defn cut-at-repetition [a-seq]
  [":("])

