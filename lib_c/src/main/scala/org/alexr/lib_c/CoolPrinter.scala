package org.alexr.lib_c

import org.alexr.lib_a.Printer

class CoolPrinter {

  def print = {
    println("CoolPrinter is using lib_a_v2")
    new Printer()
      .print2
  }

}
