import SwiftUI

/**
 * 1. Build the Home page UI natively
 */
struct HomeView: View {
    let burgers = Burger.burgers
    let columns = [GridItem(.flexible(), spacing: 16), GridItem(.flexible(), spacing: 16)]

	var body: some View {
        VStack(alignment: .leading) {
            HStack {
                Image("MenuIcon")
                    .resizable()
                    .frame(width: 28, height: 24)
                Spacer()
                Image("SearchIcon")
                    .resizable()
                    .frame(width: 52, height: 52)
            }
            .padding(.top, 36)
            VStack(alignment: .leading) {
                Text("Every Bite a")
                    .font(.custom("Montserrat", size: 32).weight(.heavy))
                    .foregroundColor(.white)
                Text("Better burger!")
                    .font(.custom("Montserrat", size: 24).weight(.regular))
                    .foregroundColor(.white)
            }
            .padding(.top, 64)
            HStack {
                HStack {
                    Circle()
                        .frame(width: 6, height: 6)
                        .foregroundColor(Color("AccentColor"))
                        .padding(.trailing, 2)
                    Text("Burgers")
                        .font(.custom("Poppins", size: 16).weight(.bold))
                        .foregroundColor(.white)
                }
                Spacer()
                Text("Pasta")
                    .font(.custom("Poppins", size: 14).weight(.regular))
                    .foregroundColor(.white)
                Spacer()
                Text("Salads")
                    .font(.custom("Poppins", size: 14).weight(.regular))
                    .foregroundColor(.white)
                Spacer()
                Image("FilterIcon")
                    .resizable()
                    .frame(width: 48, height: 48)
            }
            LazyVGrid(columns: columns, spacing: 8) {
                ForEach(burgers, id: \.id) { burger in
                    VStack(alignment: .leading) {
                        Image(burger.thumbnailName)
                        VStack(alignment: .leading, spacing: 0) {
                            Text(burger.name)
                                .font(.custom("Montserrat", size: 15).weight(.heavy))
                                .foregroundColor(.white)
                                .padding(.bottom, 4)
                            Text(burger.description)
                                .font(.custom("Montserrat", size: 11).weight(.regular))
                                .foregroundColor(.white)
                            HStack {
                                Text(String(format: "$%.2f", burger.price))
                                    .font(.custom("Montserrat", size: 13).weight(.bold))
                                    .foregroundColor(.white)
                                Spacer()
                                Text("+")
                                    .font(.custom("Montserrat", size: 16).weight(.bold))
                                    .foregroundColor(.white)
                                    .padding(8)
                                    .background(
                                        Circle()
                                            .fill(.black)
                                      )
                            }
                        }
                        .padding(.horizontal, 16)
                        .padding(.bottom, 8)
                    }
                }
            }
            .padding(.top, 8)
            Spacer()
        }
        .padding(.horizontal, 24)
        .background(Color("BackgroundColor"))
        .preferredColorScheme(.dark)
	}
}

struct HomeView_Previews: PreviewProvider {
	static var previews: some View {
		HomeView()
	}
}
