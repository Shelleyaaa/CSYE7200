/*
 * Copyright (c) 2018. Phasmid Software
 */

package edu.neu.coe.csye7200.lab99.scala99

import scala.annotation.tailrec

object P00 {
  def flatten[X](xss: List[List[X]]): List[X] = {
    @scala.annotation.tailrec
    def inner(r: List[X], wss: List[List[X]]): List[X] = wss match {
      case Nil => r
      case h :: t => inner(r ++ h, t)
    }

    inner(Nil, xss)
  }

  def fill[X](n: Int)(x: X): List[X] = {
    @scala.annotation.tailrec
    def inner(r: List[X], l: Int): List[X] = if (l <= 0) r else inner(r :+ x, l - 1)

    inner(Nil, n)
  }
}

object P01 {

  //  @scala.annotation.tailrec
  def last[X](xs: List[X]): X = xs match {
    case Nil => throw new NoSuchElementException("last: empty")
    case h :: Nil => h
    case _ :: t => last(t)
  } // TO BE IMPLEMENTED
}

object P02 {

  //  @scala.annotation.tailrec
  def penultimate[X](xs: List[X]): X = xs match {
    case Nil => throw new NoSuchElementException("penultimate: empty")
    case h :: _ :: Nil => h
    case _ :: t => penultimate(t)
  } // TO BE IMPLEMENTED
}

object P03 {

  //  @scala.annotation.tailrec
  def kth[X](k: Int, xs: List[X]): X = (k, xs) match {
    case (0, x :: _) => x
    case (n, _ :: t) => kth(n - 1, t)
    case (_, _) => throw new NoSuchElementException
  } // TO BE IMPLEMENTED
}

object P04 {

  def length[X](xs: List[X]): Int = {
    def inner[X](xs: List[X], length: Int): Int = xs match {
      case Nil => length
      case _ :: t => inner(t, length + 1)
    }
    inner(xs, 0)
  } // TO BE IMPLEMENTED

  def factorial(n: Int): BigInt = {
    def inner(r: BigInt, x: Int): BigInt = x match {
      case 1 => r
      case _ => inner(x * r, x - 1)
    }
    inner(1, n)
  }
}

object P05 {

  def reverse[X](xs: List[X]): List[X] = {
    // TO BE IMPLEMENTED
    @tailrec
    def inner(r: List[X], work: List[X]): List[X] = work match {
      case Nil => r
      case h :: t => inner(h +: r, t)
    }
    inner(Nil, xs)
  }
}

object P06 {

  //@tailrec
  def isPalindrome[X](xs: List[X]): Boolean = xs match {
    case Nil => true
    case _ :: Nil => true
    case h :: t => h == t.last && isPalindrome(t.init)
  } // TO BE IMPLEMENTED
}

object P07 {

  type ListAny = List[Any]

  def flatten(xs: ListAny): ListAny = {
    // TO BE IMPLEMENTED
    ???
  }
}

object P08 {

  def compress[X](xs: List[X]): List[X] = {
    // TO BE IMPLEMENTED
    ???
  }
}

object P09 {

  def pack[X](xs: List[X]): List[List[X]] = {
    // TO BE IMPLEMENTED
    ???
  }
}

object P10 {

  def encode[X](xs: List[X]): List[(Int, X)] = ??? // TO BE IMPLEMENTED
}

object P11 {

  def encodeModified[X](xs: List[X]): List[Any] = ??? // TO BE IMPLEMENTED
}

object P12 {

  def decode[X](xIs: List[(Int, X)]): List[X] = ??? // TO BE IMPLEMENTED
}

object P13 {

  def encodeDirect[X](xs: List[X]): List[(Int, X)] = {
    // TO BE IMPLEMENTED
    ???
  }
}

object P14 {

  def duplicate[X](xs: List[X]): List[X] = {
    // TO BE IMPLEMENTED
    ???
  }
}

object P15 {

  def duplicateN[X](n: Int, xs: List[X]): List[X] = {
    // TO BE IMPLEMENTED
    ???
  }
}
