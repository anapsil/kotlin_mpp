//
//  BaseView.swift
//  IOSMultiplatform
//
//  Created by Ana Paula da Silva on 13/08/19.
//  Copyright © 2019 Ana Paula da Silva. All rights reserved.
//

import Foundation
import common
import UIKit

extension UIViewController: BaseView {
    
    public func showError(error: KotlinThrowable) {
        let title:String = "Error"
        var errorMessage: String? = nil
        
        switch error{
        case is UpdateProblem:
            errorMessage = "Failed to get data from server, please check your internet connection"
        default:
            errorMessage = "Unknown error"
        }
        
        if let message = errorMessage {
            self.showError(title: title, message: message)
        }
    }
    
    func showError(title:String, message: String) {
        let alertController = UIAlertController(title: title, message: message,
                                                preferredStyle: UIAlertController.Style.alert)
        alertController.addAction(UIAlertAction(title:"Dismiss", style: UIAlertAction.Style.default, handler: nil))
        self.present(alertController, animated: true, completion: nil)
    }
}
