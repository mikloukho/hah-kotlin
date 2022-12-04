package Entities

interface Healer {
    abstract var healCharges: Int
    abstract val maxHealthPoints: Int
    abstract var healthPoints: Int
    val healingPercent: Int
        get() = 50

    fun healing() {
        println("${this::class.simpleName} использовал лечение")
        healthPoints += (maxHealthPoints / 100) * healingPercent
        healCharges--
    }

    fun canHeal(): Boolean {
        return healCharges > 0
    }

}