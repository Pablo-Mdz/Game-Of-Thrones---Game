/**
 *  White Walkers class, inheriting from the Enemy class.
 */
class WhiteWalkers(name: String, hp: Int = 100) : Enemy(name, hp) {


    /**
     * Executes a random attack on a selected hero.
     *
     * @param randomHero The hero randomly selected to be attacked.
     * Asket to chatGPT how manage the random funktions.
     */
    fun whiteWalkerRandomAttack(randomHero: Heroes) {

        val actions =
            listOf(::silentAttack, ::snowBalls, ::snowAvalanche, ::attackByQuantity, ::callTheDeadMonsters, ::iceSpikes)
        val action = actions.random()
        action(randomHero)
        sounds.playSound(sounds.arrows)
        Thread.sleep(800)
        sounds.playSound(sounds.ahu)
        Thread.sleep(800)
        sounds.playSound(sounds.ahuWoman)
        Thread.sleep(800)

    }



    /**
     * Performs a silent attack on a hero, causing 10 hp damage.
     *
     * @param randomHero The hero to be attacked.
     */
    fun silentAttack(randomHero: Heroes) {
        println("$name's army are hidden in the snow and attack from below without being seen, ${randomHero.name} loses 10 hp")
        println()
        gollum()
        randomHero.takeDamage(10)
    }

    /**
     * Throws snowballs with crystals at a hero, causing 8 hp damage.
     *
     * @param randomHero The hero to be attacked.
     */
    fun snowBalls(randomHero: Heroes) {
        println("$name's army have learned to throw snowballs that contain crystals inside, which hurts humans a lot, ${randomHero.name}  loses 8ph")
        println()
        snowBalls()
        randomHero.takeDamage(8)
    }

    /**
     * Sends a snow avalanche towards a hero, causing 7 hp damage.
     *
     * @param randomHero The hero to be attacked.
     */
    fun snowAvalanche(randomHero: Heroes) {
        println("$name sent a snow avalanche to ${randomHero.name}, loses 7 hp")
        println()
        snowAvalanche()
        randomHero.takeDamage(7)
    }

    /**
     * Attacks with a large number of White Walkers, causing 5 hp damage.
     *
     * @param randomHero The hero to be attacked.
     */
    fun attackByQuantity(randomHero: Heroes) {
        println("$name has send 2000 white walkers to the battle, unfortunatly ${randomHero.name} was first on the line and lost 10 hp")
        println()
        attackAction()
        randomHero.takeDamage(5)
    }

    /**
     * Calls a dragon to attack a hero, causing 10 hp damage.
     *
     * @param randomHero The hero to be attacked.
     */
    fun callTheDeadMonsters(randomHero: Heroes) {
        println("$name has call the dead Monsters! and ${randomHero.name} was affected with his cruelty, it lost 10 hp")
        println()
        whiteDragon()
        randomHero.takeDamage(10)
    }

    /**
     * Attacks with ice spikes, causing 5 hp damage to a hero.
     *
     * @param randomHero The hero to be attacked.
     */

    fun iceSpikes(randomHero: Heroes) {
        println("$name attacks with ice spikes sharpened by years! and ${randomHero.name} was affected first and lost 5 hp")
        println()
        randomHero.takeDamage(9)
        arrows()
    }


    /**
     * Launches a mass attack with ice spears, causing 15 hp damage to all heroes.
     *
     * @param heroes The list of heroes to be attacked.
     */
    fun iceSpears(heroes: MutableList<Heroes>) {

        println(" The White Walker spear ice of all the valley!, all the heroes lost 15 hp ")
        heroes.forEach { it.takeDamage(13) }
          wind()
        sounds.playSound(sounds.ice)
        Thread.sleep(800)
        sounds.playSound(sounds.ahu)
        Thread.sleep(800)
        sounds.playSound(sounds.ahuWoman)
        Thread.sleep(800)
    }

    /**
     * Checks and updates the living status of the White Walker.
     * It is used to determine if the White Walker is still alive in the game.
     */
    override fun isLive() {
        super.isLive()

    }

}