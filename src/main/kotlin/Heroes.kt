/**
 * Father class for heroes in the game.
 */
open class Heroes(open var name: String, open var hp: Int) {

    var skipTurn: Boolean = false
    val sounds = Sounds()

    /**
     * Displays the menu of actions a hero can take and processes the selected action.
     *
     * @param whiteWalker An instance of WhiteWalkers, representing the enemy.
     * @param whiteDragon An instance of WhiteDragon, representing the second enemy.
     * @param bag An instance of Bag, representing a shared resource for heroes (vitamin and Potions).
     */
    open fun menuActions(
        whiteWalker: WhiteWalkers,
        whiteDragon: WhiteDragon,
        bag: Bag,
        allHeroes: MutableList<Heroes>,
        enemies: List<Enemy>
    ) {

        if (!skipTurn) {
            var action: Int
            do {
                try {
                    println("${changeColor()}^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^")
                    println("$name, What would you like to do?")
                    println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^$reset")
                    println()
                    println("1. Attack the White Walkers")
                    println(if (whiteWalker.hp <= 55) "2. Attack the White Dragon" else "2. ------------------------")
                    println("3. Heal")
                    println("4. Valyrian Extra Power!")
                    println("5. Use Bag with Potion and vitamin")
                    println("6. See the actual HP of all on this round")
                    action = readln().toInt()

                    when (action) {
                        1 -> {
                            attackWhiteWalker(whiteWalker)
//                            sounds.playSound(sounds.menu)
                        }
                        2 -> {
//                            sounds.playSound(sounds.menu)
                            if (whiteWalker.hp <= 55) attackWhiteDragon(whiteDragon) else action = 0
                        }
                        3 -> {
                                heal()
                                sounds.playSound(sounds.menu)
                        }
                        4 -> {
                            sounds.playSound(sounds.menu)
                            valyrianExtraPower(this)
                            if (skipTurn) {
                                println("$name is skipping the rest of this turn because has used the Valyrian extra power.")
                                continue
                            } else action = 0
                        }
                        5 -> {
                            sounds.playSound(sounds.menu)
                            bag.useBag(this)
                            if (skipTurn) {
                                println("$name is skipping the rest of this turn because has used the power from the bag.")
                                continue
                            } else action = 0
                        }
                        6 -> {
                            sounds.playSound(sounds.menu)
                            actualHpOffAll(allHeroes, enemies)
                            action = 0
                        }
                        else -> {
                            sounds.playSound(sounds.menu)
                            println("Invalid option, please try again.")
                            action = 0
                        }
                    }
                } catch (e: NumberFormatException) {
                    println("Invalid input, please enter a number.")
                    action = 0
                }
            } while (action !in 1..6)
        } else {
            println("$name is skipping this turn.")
            this.skipTurn = false
        }
    }


    /**
     * Attacks a White Walker, reducing its health by a specified amount.
     *
     * @param whiteWalker The White Walker to be attacked.
     */
    open fun attackWhiteWalker(whiteWalker: WhiteWalkers) {
        whiteWalker.takeDamage(12)

    }

    /**
     * Attacks a White Dragon, reducing its health by a specified amount.
     *
     * @param whiteDragon The White Dragon to be attacked.
     */
    open fun attackWhiteDragon(whiteDragon: WhiteDragon) {
        whiteDragon.takeDamage(12)

    }

    /**
     * Displays the current health points of the hero.
     */
    open fun individualHp() {
        println("The actual Hp from ${name} is: ${hp}")
        isLive()
    }


    /**
     * Checks and updates the living status of the hero.
     * Announces if the hero is dead when health points reach zero.
     */
    open fun isLive() {
        if (hp in 1..20) {
            println("  $yellow you are almost to die, be careful! 🤕$reset")
        } else if (hp <= 0) {
            println("$red  $name you are dead  ☠️$reset")
            hp = 0
        }
    }


    /**
     * Displays the current health points of all heroes and enemies in the game.
     */
    open fun heal() {
        println("you've open your personal heal pocket: 🧳")
    }


    /**
     * Activates an extra power for the hero.
     */
    open fun valyrianExtraPower(hero: Heroes) {
        println("EXTRA POWER!! ")
        skipTurn = true
        sounds.playSound(sounds.live)
    }

    /**
     * Reduces the hero's health by a specified amount.
     *
     * @param damageAmount The amount of damage to be taken by the hero.
     */
    open fun takeDamage(damageAmount: Int) {
        hp -= damageAmount
        if (hp < 0) {
            hp = 0
        }
    }

    /**
     * Increases the hero's health points by a specified amount.
     *
     * @param addAmount The amount of health points to be added to the hero.
     */
    open fun addPoints(addAmount: Int) {
        hp += addAmount
        if (hp <= 0) {
            hp = 0
        }
    }


}
