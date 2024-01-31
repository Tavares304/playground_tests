package com.tavares.playgorund.playgroundandtests

import com.tavares.playgorund.playgroundandtests.bagunca.classes.Numero
import com.tavares.playgorund.playgroundandtests.bagunca.classes.Soma
import com.tavares.playgorund.playgroundandtests.bagunca.interfaces.Expression
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.lang.IllegalArgumentException

@SpringBootApplication
class PlaygroundandtestsApplication

fun main(args: Array<String>) {
	runApplication<PlaygroundandtestsApplication>(*args)

	val testeNumero = evalWithLogging(Numero(22))
	println("--------------------separation--------------------")
	val testeSoma = evalWithLogging(Soma(Numero(3),Numero(7)))
}

fun evalWithLogging(e: Expression): Int =
		when (e) {
			is Numero -> {
				println("num: ${e.value}")
				e.value
			}
			is Soma -> {
				val left = evalWithLogging(e.left)
				val right = evalWithLogging(e.right)
				println("Sum: $left + $right = ${left+right}"  )
				left + right
			}
			else -> throw IllegalArgumentException("Unknown Expression")
		}
