import Foundation
import CoreData


class BurgerPersistentContainer: NSPersistentContainer {
    
    func saveContext(backgroundContext: NSManagedObjectContext? = nil) {
            let context = backgroundContext ?? viewContext
            guard context.hasChanges else { return }
            do {
                try context.save()
            } catch let error as NSError {
                print("Error: \(error), \(error.userInfo)")
            }
        }
}
