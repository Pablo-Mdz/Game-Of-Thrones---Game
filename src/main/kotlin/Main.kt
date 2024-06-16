fun main() {
    val bag = Bag()
    val sounds = Sounds()
    val difficulty = DifficultyMenu()
    var round: Int = 1
    var callTheDragon = false

    val drogon = WhiteDragon("Drogon", 100)
    val ww = WhiteWalkers("White Walker", 100)
    val houseTargaryen = HouseTargaryen("Daenerys Targaryen", 100)
    val houseStark = HouseStark("Jon Snow", 100)
    val houseLannister = HouseLannister("Cersei Lannister", 100)
    val allHeroes = mutableListOf(houseStark, houseLannister, houseTargaryen)
    val enemies = listOf(ww, drogon)

    sounds.playSound(sounds.intro)
    got()
    dragonPresentation()
    difficulty.menuDifficulty(enemies)
    difficulty.newValuesDifficulty(enemies, difficulty.selectedDifficulty)
    do {
        round(round)
        sounds.playSound(sounds.round)
        for (hero in allHeroes) {
            if (hero.hp > 0)
                hero.menuActions(ww, drogon, bag, allHeroes, listOf(ww, drogon))
        }
        enemiesAttackTittle()
        firstAttackTittle()
        ww.whiteWalkerRandomAttack(allHeroes.random())
        secondAttackTittle()
        ww.iceSpears(allHeroes)

        if (ww.hp <= 50) {
            if (!callTheDragon) {
                Thread.sleep(800)
                println("$bgpink$red White Walker has call The white Dragon for help!!! \n$reset")
                callTheDragon = true
            }
            drogon.dragonRandomAttack(allHeroes.random())
        }
        println()
        println("$bgGreen$white--------HEROES HP----------- \n$reset")
        allHeroes.forEach { it.individualHp() }
        println()
        println("$bgpink$white--------ENEMIES HP-----------\n$reset")
        enemies.forEach { it.actualHp() }
        println("$bgWhite$red------------------------------------------------------------------------------\n$reset")
        println()

        round++
        changeColor()
        bag.usedThisRound = false
    } while ((drogon.hp > 0 || ww.hp > 0) && (houseStark.hp > 0 || houseLannister.hp > 0 || houseTargaryen.hp > 0))

    if (drogon.hp <= 0 && ww.hp <= 0) {
        humansWon()
    } else {
        enemyWon()
    }
}