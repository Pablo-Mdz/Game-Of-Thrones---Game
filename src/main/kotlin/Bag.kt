open class Bag {
    var potions = 3
    var vitamins = 1
    var usedThisRound = false
    val sounds = Sounds()




    /**
     * Allows a hero to choose and use an item from the bag.
     *
     * @param hero The hero who is using the bag.
     * If the hero uses a potion or vitamin, they lose their current turn, if not, return to the principal menu.
     */
    fun useBag(hero: Heroes) {
        if (usedThisRound) {
            println("The bag has already been used this round. Try again next round! 💪🏻")
            return
        }
            println("What do you want to use from the common bag? 🎒")
            println("1. Potion 🧪")
            println("2. Vitamin 💊")
            println("3. Exit")
            try {
                val answer = readln().toInt()
                when (answer) {
                    1 -> {
                        sounds.playSound(sounds.menu)
                        usePotion(hero)
                        usedThisRound = true
                    }
                    2 -> {
                        sounds.playSound(sounds.menu)
                        useVitamin(hero)
                        usedThisRound = true
                    }
                    3 -> {
                        sounds.playSound(sounds.menu)
                        println("You are back to the game")
                        hero.skipTurn = false
                    }
                    else -> {
                        sounds.playSound(sounds.menu)
                        println("Invalid option, try again")
                        hero.skipTurn = false
                    }
                }
            } catch (e: Exception) {
                println("Invalid option, try again")
            }

    }


    /**
     * Allows a hero to use a potion from the bag to recover half of their health points.
     * If a potion is used, the available quantity in the bag is decreased.
     *
     * @param hero The hero who is using the potion.
     * If the potion is chosen to be used, the hero loses their current turn and return to the principal menu.
     */
    fun usePotion(hero: Heroes) {
        if (potions > 0) {
            println("${hero.name}, you have $potions potion(s) in the bag.")
            println("Do you want to use a potion? (y/n)")
            val answer = readln().toLowerCase()
            if (answer == "y") {
                sounds.playSound(sounds.live)
                Thread.sleep(200)

                potions -= 1
                hero.addPoints(hero.hp / 2)
                println("${hero.name} used a potion. All the humans have $potions potion(s) left.")
                hero.skipTurn = true
            } else {
                sounds.playSound(sounds.menu)
                println("You have ${potions} potions left")
                hero.skipTurn = false
            }
        } else {
            println("No potions left.")
            hero.skipTurn = false
        }
    }


    /**
     * Allows a hero to use a vitamin from the bag to increase their health by 20% of their current health.
     * If a vitamin is used, the available quantity in the bag is decreased.
     *
     * @param hero The hero who is using the vitamin.
     * If the vitamin is chosen to be used, the hero loses their current turn and return to the principal menu.
     */
    fun useVitamin(hero: Heroes) {
        if (vitamins > 0) {
            println("${hero.name}, you have $vitamins vitamin(s) in the bag.")
            println("Do you want to use a vitamin? (y/n)")
            val answer = readln().toLowerCase()

            if (answer == "y" && vitamins != 0) {
                sounds.playSound(sounds.live)
                Thread.sleep(200)
                vitamins -= 1
                hero.hp += (hero.hp / 100) * 20 //20%
                println("${hero.name} used a vitamin. You have $vitamins vitamin(s) left.")
                hero.skipTurn = true
            } else {
                sounds.playSound(sounds.menu)
                println("invalid option, let's back to the game!")
                hero.skipTurn = false
            }
        } else {
            println("No vitamins left.")
            hero.skipTurn = false
        }
    }
}
