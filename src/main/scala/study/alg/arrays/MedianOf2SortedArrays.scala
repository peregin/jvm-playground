package study.alg.arrays

object MedianOf2SortedArrays extends App {

  // arrays are sorted
  // for odd number is the avg of the middle two elements
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    var i1 = 0
    var i2 = 0
    val n1 = nums1.length
    val n2 = nums2.length
    val n = n1 + n2

    def next(): Int = {
      var item = 0
      if (i1 <= n1 && i2 <= n2) {
        if (i1 >= n1) {
          item = nums2(i2)
          i2 += 1
        } else if (i2 >= n2) {
          item = nums1(i1)
          i1 += 1
        } else if (nums1(i1) < nums2(i2)) {
          item = nums1(i1)
          i1 += 1
        } else {
          item = nums2(i2)
          i2 += 1
        }
      } else sys.error((s"out of range $i1, $i2"))
      item
    }

    val mid = n / 2
    var m1 = 0
    (0 until mid).foreach{ix =>
      //println(s"ix=$ix, i1=$i1, i2=$i2")
      m1 = next()
    }
    if (n % 2 == 0) {
      val m2 = next()
      (m1 + m2) / 2.0
    } else next()
  }

  //val sol  = findMedianSortedArrays(Array(1, 2), Array(3, 4))
  val sol  = findMedianSortedArrays(Array(0, 0), Array(0, 0))
  println(s"sol is: $sol")
}
