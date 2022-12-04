package Entities

class Tanos(attack: Int, minDamage: Int, maxDamage: Int, healthPoints: Int, protection: Int) :
    Entity(attack, minDamage, maxDamage, healthPoints, protection), Healer {
    override var healCharges = 3
}