//
//  AppDelegate.swift
//  IOSMultiplatform
//
//  Created by Ana Paula da Silva on 31/07/19.
//  Copyright © 2019 Ana Paula da Silva. All rights reserved.
//

import UIKit
import common

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {

    public lazy var dataRepository = { MembersDataRepository(api: GitHubApi()) }
    
    var window: UIWindow?
    
    static var appDelegate: AppDelegate {
        return UIApplication.shared.delegate as! AppDelegate
    }
}

