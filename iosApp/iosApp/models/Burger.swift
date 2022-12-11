import Foundation

/**
 * 2.1. Create the Burger model natively
 */
struct Burger: Identifiable {
    let id: Int
    let name: String
    let description: String
    let price: Float
    let thumbnailName: String
    
    init(id: Int, name: String, description: String, price: Float, thumbnailName: String) {
        self.id = id
        self.name = name
        self.description = description
        self.price = price
        self.thumbnailName = thumbnailName
    }
}

/**
 * 3.1.1. Play with the Burgers data using a static list (Native)
 */
extension Burger {
    static var burgers: [Burger] {
        [
            Burger(
                id: 0,
                name: "Beef Burger",
                description: "Onion with cheese",
                price: 18,
                thumbnailName: "BeefBurgerThumbnail"
            ),
            Burger(
                id: 1,
                name: "Chicken Burger",
                description: "Cheese with chicken",
                price: 12,
                thumbnailName: "ChickenBurgerThumbnail"
            ),
            Burger(
                id: 2,
                name: "Classic Burger",
                description: "Beef with lettuce",
                price: 24,
                thumbnailName: "ClassicBurgerThumbnail"
            ),
            Burger(
                id: 3,
                name: "Grilled Burger",
                description: "Grilled chicken",
                price: 14,
                thumbnailName: "GrilledBurgerThumbnail"
            )
        ]
    }
}
