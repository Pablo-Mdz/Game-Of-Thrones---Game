/**
 * Father base class for enemies in the game.
 */
open class Enemy(open var name: String, var hp: Int) {

    /**
     * Displays the current health points of the enemy.
     */
    open fun actualHp() {
        println("The actual Hp from ${name} is: ${hp}")
        isLive()
    }

    /**
     * Checks and updates the living status of the enemy.
     * Announces if the enemy is very weak or dead.
     */
    open fun isLive() {
        if (hp in 1.. 20) {
            println("your enemy is very weak, you can kill it with one attack!! 🤕")
        } else if (hp <= 0) {
            println("$name Is dead!! ☠️")
            hp = 0

        }
    }

    /**
     * Reduces the enemy's health by a specified amount.
     * Ensures that the health does not drop below zero.
     *
     * @param damageAmount The amount of damage to be inflicted on the enemy.
     */
    open fun takeDamage(damageAmount: Int) {
        hp -= damageAmount
        if (hp < 0) {
            hp = 0
        }
    }

}
