open class DifficultyMenu {
    val sounds = Sounds()
    var selectedDifficulty: Difficulty = Difficulty.MEDIUM

    fun menuDifficulty(enemies: List<Enemy>) {
        var validInput = false
        while (!validInput) {
            println("${bgBlack}🏰 Select Difficulty Level 🏰:")
            println("1. 🌟 Easy 🌟")
            println("2. ⚔️ Medium ⚔️")
            println("3. 🐉 Hard 🐉 \n$reset")

            try {
                val choice = readln().toInt()
                when (choice) {
                    1 -> {
                        sounds.playSound(sounds.menu)
                        selectedDifficulty = Difficulty.EASY
                        validInput = true
                    }
                    2 -> {
                        sounds.playSound(sounds.menu)
                        selectedDifficulty = Difficulty.MEDIUM
                        validInput = true
                    }
                    3 -> {
                        sounds.playSound(sounds.menu)
                        selectedDifficulty = Difficulty.HARD
                        validInput = true
                    }
                    else -> {
                        sounds.playSound(sounds.menu)
                        println("Invalid selection, please try again.")
                    }
                }
            } catch (e: NumberFormatException) {
                println("Invalid input, please enter a number.")
                sounds.playSound(sounds.menu)
            }
        }
        println("Selected Difficulty: $selectedDifficulty")
        newValuesDifficulty(enemies, selectedDifficulty)
    }

    fun newValuesDifficulty(enemies: List<Enemy>, difficulty: Difficulty) {
        when (difficulty) {
            Difficulty.EASY -> {
                enemies.forEach { it.hp /= 2 }
            }
            Difficulty.MEDIUM -> {
                enemies.forEach { it.hp = it.hp }
            }

            Difficulty.HARD -> {
                enemies.forEach { it.hp += (it.hp/2) }
            }
        }
    }
}
