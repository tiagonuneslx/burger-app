import Foundation
import CoreData

struct BurgersProvider {
    
    static let shared = BurgersProvider()
    
    let container: BurgerPersistentContainer
    
    init() {
        container = BurgerPersistentContainer(name: "BurgerAppModel")
        container.loadPersistentStores { description, error in
            if let error = error {
                fatalError("Unable to load persistent stores: \(error)")
            }
        }
    }
    
    /**
     * 3.1.2. Play with the Burgers data natively using static database
     */
    func prepopulateDb() {
        let entity = NSEntityDescription.entity(forEntityName: "Burger", in: container.viewContext)!
        BurgerStatic.burgers.forEach { burgerStatic in
            let burger = NSManagedObject(entity: entity, insertInto: container.viewContext)
            burger.setValue(burgerStatic.id, forKey: "id")
            burger.setValue(burgerStatic.name, forKey: "name")
            burger.setValue(burgerStatic.description, forKey: "description_")
            burger.setValue(burgerStatic.price, forKey: "price")
            burger.setValue(burgerStatic.thumbnailName, forKey: "thumbnailName")
        }
        container.saveContext()
        UserDefaults.standard.set(true, forKey: "hasPrepopulatedDb")
    }
}
