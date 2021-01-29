package org.alexr.lib_b

import org.alexr.lib_a.Printer

class SmartPrinter {

  def print = {
    println("SmartPrinter is using lib_a_v1")
    new Printer()
      .print1
  }

}
