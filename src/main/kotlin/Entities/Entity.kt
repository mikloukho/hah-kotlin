package Entities

abstract class Entity(
    private val attack: Int,
    private val minDamage: Int,
    private val maxDamage: Int,
    var healthPoints: Int,
    val protection: Int
) {
    var alive: Boolean = true
    val maxHealthPoints: Int = healthPoints

    fun takeDamage(damage: Int) {
        healthPoints -= damage
        if (healthPoints <= 0) {
            healthPoints = 0
            alive = false
        }
    }

    fun attack(enemy: Entity) {

        val attackModifier = (attack - enemy.protection) + 1
        if (attackIsSuccess(attackModifier)) {
            val damage = (attackModifier + minDamage + maxDamage) / 3
            println("${enemy::class.simpleName} получил $damage урона от ${this::class.simpleName}")
            enemy.takeDamage(damage)
        }else{
            println("${enemy::class.simpleName} уклонился от атаки ${this::class.simpleName}")
        }
    }

    private fun attackIsSuccess(attackModifier: Int): Boolean {
        var result: Int
        var throwsCount = 1;
        do {
            result = (1..6).random()
            if (result == 5 || result == 6) {
                return true
            }
            throwsCount++
        } while (attackModifier > throwsCount)
        return false
    }

}