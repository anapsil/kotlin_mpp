//
//  MemberList.swift
//  IOSMultiplatform
//
//  Created by Ana Paula da Silva on 13/08/19.
//  Copyright © 2019 Ana Paula da Silva. All rights reserved.
//

import Foundation
import common

class MemberList {
    var members: [Member] = []
    
    func updateMembers(_ newMembers:[Member]) {
        members.removeAll()
        members.append(contentsOf: newMembers)
    }
}
