/**
 *  House Lannister class, inheriting from the Heroes class.
 */
class HouseLannister(name:String,  hp:Int =100) : Heroes(name, hp){


    // WITH WHITE WALKERS
    /**
     * Attacks a White Walker. This override allows House Lannister to perform a special attack.
     *
     * @param whiteWalker The White Walker being attacked.
     * The attack decreases the White Walker's health by 10 points and invokes the army function.
     */
    override fun attackWhiteWalker(whiteWalker : WhiteWalkers) {
        super.attackWhiteWalker(whiteWalker)
        sounds.playSound(sounds.army)
        println("$name attacked the white Walker with the Army and take 12 hp! ${whiteWalker.name} has ${whiteWalker.hp} hp left")
        army()

    }


    // WITH WHITE DRAGON
    /**
     * Attacks a White Dragon. This override allows House Lannister to perform a special attack.
     *
     * @param whiteDragon The White Dragon being attacked.
     * The attack decreases the White Dragon's health by 10 points and invokes the army function.
     */
    override fun attackWhiteDragon(whiteDragon : WhiteDragon) {
        super.attackWhiteDragon(whiteDragon)
        sounds.playSound(sounds.army)
        println("$name attacked the white Dragon with the Army and take 12 hp! ${whiteDragon.name} has ${whiteDragon.hp} hp left")
        army()
    }



    /**
     * Heals the hero using rest and recovery methods.
     * It uses available healing herbs and recovers 20 health points.
     */

    var personalHealPocket: Boolean = false
    override fun heal() {
        super.heal()
        if (!personalHealPocket) {
            println("$name you have paid for the army of Bravos to help in the battle and recover 20 hp!")
            addPoints(20)
            personalHealPocket = true

        }   else {
        println("you don't have more money to buy another army and you wasted time searching, you lose this turn...")
    }
    }



    var counterExtraPower = true
    /**
     * Activates extra power for House Lannister.
     * It can be used once to gain additional resources from the iron bank, increasing health by 26% of current health.
     */
    override fun valyrianExtraPower(hero: Heroes) {
        super.valyrianExtraPower(hero)
        if(counterExtraPower) {
        println("The iron bank has lent you more money, to buy valyrian steel weapons, you increase your hp  by 26%! - Lose your turn.")
            this.hp += (hp / 100) * 26
            counterExtraPower = false
        } else {
            println("You have already used your extra power")
        }
    }


    /**
     * Checks and updates the living status of the hero.
     * It is used to determine if the hero is still alive in the game.
     */
    override fun isLive() {
        super.isLive()

    }
}