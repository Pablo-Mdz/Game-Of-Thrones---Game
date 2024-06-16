/**
 *  House Targaryen class, inheriting from the Heroes class.
 */
class HouseTargaryen( name:String,  hp:Int =100) : Heroes(name, hp){


    // WITH WHITE WALKERS
    /**
     * Attacks the White Walker. This override allows House Targaryen to perform a special attack.
     *
     * @param whiteWalker The White Walker being attacked.
     * The attack decreases the White Walker's health by 10 points and invokes the dragon function.
     */
    override fun attackWhiteWalker(whiteWalker : WhiteWalkers) {
        sounds.playSound(sounds.dragon)
        super.attackWhiteWalker(whiteWalker)
        println("$name attacked the White Walker with the power of the Dragon fire and take 12 hp! ${whiteWalker.name} has ${whiteWalker.hp} hp left")
        dragon()

    }

    //WITH WHITE DRAGON
    /**
     * Attacks the White Dragon. This override allows House Targaryen to perform a special attack.
     *
     * @param whiteDragon The White Dragon being attacked.
     * The attack decreases the White Dragon's health by 10 points and invokes the dragon function.
     */
    override fun attackWhiteDragon(whiteDragon : WhiteDragon) {
        super.attackWhiteDragon(whiteDragon)
        sounds.playSound(sounds.dragon)
        println("$name attacked the white Dragon with the power of the Dragon fire and take 12 hp! ${whiteDragon.name} has ${whiteDragon.hp} hp left")
        dragon()
    }


    /**
     * Heals the hero using the power of Dragon Blood.
     * It uses available healing herbs and recovers 20 health points.
     */
    var personalHealPocket: Boolean = false
    override fun heal() {
        super.heal()
        if (!personalHealPocket) {
            println("$name is healing with the power of the Dragon Blood and recover 20 hp!")
            addPoints(20)
            personalHealPocket = true
        } else {
            println("you don't have more Dragon Blood and you wasted time searching, you lose this turn...")
        }
    }



    var counterExtraPower = true
    /**
     * Activates extra power for House Targaryen.
     * It can be used once to call the lost dragon Viserion, increasing health by 28% of current health.
     */
    override fun valyrianExtraPower(hero: Heroes) {
        super.valyrianExtraPower(hero)
        if(counterExtraPower) {
            println("$name your dragon Viserion has come with valyrian Fire to help you! With its strength you increase 28 hp! - Lose your turn.")
            this.hp += (hp / 100) * 28
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