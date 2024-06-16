/**
 *  House Stark class, inheriting from the Heroes class.
 */
class HouseStark(name: String, hp: Int = 100) : Heroes(name, hp) {

    //  WHITH WALKERS ATTACK
    /**
     * Attacks the White Walker. This override allows House Stark to perform a special attack.
     *
     * @param whiteWalker The White Walker being attacked.
     * The attack decreases the White Walker's health by 10 points and invokes the wolf function.
     */
    override fun attackWhiteWalker(whiteWalker: WhiteWalkers) {
        super.attackWhiteWalker(whiteWalker)
        sounds.playSound(sounds.wolf)
        println("$name attacked the white Walker with the guargo Wolf and take 12 hp! ${whiteWalker.name} has ${whiteWalker.hp} hp left")
        wolf()
    }

    //WITH  DRAGON
    /**
     * Attacks the White Dragon. This override allows House Stark to perform a special attack.
     *
     * @param whiteDragon The White Dragon being attacked.
     * The attack decreases the White Dragon's health by 10 points and invokes the wolf function.
     */
    override fun attackWhiteDragon(whiteDragon: WhiteDragon) {
        super.attackWhiteDragon(whiteDragon)
        sounds.playSound(sounds.wolf)
        println("$name attacked the white Dragon with the guargo Wolf and take 12 hp! ${whiteDragon.name} has ${whiteDragon.hp} hp left")
        wolf()

    }



    /**
     * Heals the hero using Northern Herbs from a secret cave.
     * It uses available healing herbs and recovers 20 health points.
     */
    var personalHealPocket: Boolean = false
    override fun heal() {
        super.heal()
        if (!personalHealPocket) {
            println("$name is cured With North Herbs from the secret cave, you recover 20 hp!")
            addPoints(20)
            personalHealPocket = true
        } else {
            println("you don't have more herbs from the North and you wasted time searching, you lose this turn...")
        }
    }

    var counterExtraPower = true
    /**
     * Activates extra power for House Stark.
     * It can be used once to call upon the Night Guard for assistance, increasing health by 30% of current health.
     */
    override fun valyrianExtraPower(hero: Heroes) {
        super.valyrianExtraPower(this)
        if(counterExtraPower) {
        println("$name, the night guard has heard your request and has joined the fight and bring 100 valyrian steel swords! With its help, you increase your hp by 32%!")
            this.hp += (hp / 100) * 30
            counterExtraPower = false
        } else {
            println("You have already used your extra power")
            hero.skipTurn = false
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