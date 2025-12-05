//
// Created by Juan Diego Tonguino on 2/12/25.
//

import Foundation
import ComposeApp
import SwiftUI

extension FontFamilyToken {
    func font(size: CGFloat, weight: Font.Weight = .regular) -> Font {
        switch weight {
        case .bold:
            return Font.custom("Inter-Bold", size: size)
        case .medium:
            return Font.custom("Inter-Medium", size: size)
        default:
            return Font.custom("Inter-Regular", size: size)
        }
    }
}

extension Spacing {
    var mediumPx: CGFloat { CGFloat(medium) }
}