/**
 *  White Dragon class, inheriting from the Enemy class.
 */
class WhiteDragon( name: String,  hp: Int =100) : Enemy(name, hp) {

    /**
     * Executes a random attack on a selected hero.
     *
     * @param randomHero The hero randomly selected to be attacked.
     */
    fun dragonRandomAttack(randomHero: Heroes) {
        val actions = listOf(::attackWithWhiteFire, ::splitCold, ::frostBreath, ::magesticFlight)

        val action = actions.random()
        println("$bgWhite$red********** DRAGON ATTACK!!  ******************** \n$reset")
        sounds.playSound(sounds.dragon)
        action(randomHero)
        sounds.playSound(sounds.ahu)
        Thread.sleep(1300)
        sounds.playSound(sounds.arrows)
        sounds.playSound(sounds.ahuWoman)
    }

    /**
     * Performs an attack with white fire, causing 10 hp damage to a hero.
     *
     * @param randomHero The hero to be attacked.
     */
    fun attackWithWhiteFire(randomHero : Heroes) {

        println("$name is angry and spread white fire everywhere!, unfortunatly ${randomHero.name} was affected first and lost 10 hp")
        randomHero.takeDamage(10)
        whiteFire()

    }


    /**
     * Performs a split cold attack on a hero, causing 7 hp damage.
     *
     * @param randomHero The hero to be attacked.
     */
    fun splitCold(randomHero : Heroes) {
        println("$name don't like the humans, and split cold to ${randomHero.name} and lost 7 hp")
        randomHero.takeDamage(7)
        cold()
    }

    /**
     * Performs a frost breath attack on a hero, causing 10 hp damage.
     *
     * @param randomHero The hero to be attacked.
     */
    fun frostBreath(randomHero : Heroes) {

println("$name is angry and spread frost breath everywhere!, unfortunatly ${randomHero.name} was affected first and lost 10 hp")
        randomHero.takeDamage(10)
    wind()
    }

    /**
     * Performs a majestic flight attack on a hero, causing 4 hp damage.
     *
     * @param randomHero The hero to be attacked.
     */
    fun magesticFlight(randomHero : Heroes) {
 println("$name has a majestic flight, while the humans look at it, the white walkers attack! ${randomHero.name} lose 10 hp ")
        randomHero.takeDamage(4)
        fly()
    }


    /**
     * Checks and updates the living status of the enemy.
     * Announces if the enemy is very weak or dead.
     */
    override fun isLive() {
        super.isLive()

    }
}