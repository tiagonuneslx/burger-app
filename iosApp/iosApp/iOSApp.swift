import SwiftUI

@main
struct iOSApp: App {
	var body: some Scene {
		WindowGroup {
			HomeView()
                .environment(\.managedObjectContext, BurgersProvider.shared.container.viewContext)
                .onAppear {
                    if UserDefaults.standard.bool(forKey: "hasPrepopulatedDb") == false {
                        BurgersProvider.shared.prepopulateDb()
                    }
                }
		}
	}
}
