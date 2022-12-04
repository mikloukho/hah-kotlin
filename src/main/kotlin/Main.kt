import Entities.*

fun main(args: Array<String>) {
    val hero = Tanos(15, 10, 20, 100, 7)
    val monsters = listOf(
        IronMan(15, 5, 20, 100, 6),
        Hulk(15, 5, 20, 100, 6),
        Thor(15, 5, 20, 100, 6)
    )
    infinityWar(hero, monsters)
}

private fun infinityWar(hero: Entity, monsters: List<Entity>) {
    var aliveMonsters = monsters.filter { it.alive }
    while(hero.alive && aliveMonsters.size != 0){
        for(monster in aliveMonsters){
            monster.attack(hero)
            if(hero.healthPoints < hero.maxHealthPoints / 2 && (hero is Healer) && hero.canHeal()){
                hero.healing()
            }else if(!hero.alive){
                break
            }

            hero.attack(monster)
            aliveMonsters = aliveMonsters.filter { it.alive }
        }
    }
    if(hero.alive){
        println("Герой победил ${hero.healthPoints}" )
    }else  {
        println("Монстры победели ${aliveMonsters.size}")
    }

}