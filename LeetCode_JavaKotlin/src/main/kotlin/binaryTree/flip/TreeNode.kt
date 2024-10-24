package org.example.binaryTree.flip

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    constructor(dataPoints: List<Int?>) : this(dataPoints.firstOrNull() ?: throw IllegalArgumentException("List cannot be empty")) {
        // Call makeTree to build the tree and assign the root
        val root = makeTree(dataPoints)
        if (root != null) {
            this.`val` = root.`val`
            this.left = root.left
            this.right = root.right
        }
    }

    fun makeTree(values: List<Int?>): TreeNode? {
        if (values.isEmpty()) return null

        // Create a list of nullable TreeNode objects, where nulls in values list result in null TreeNode
        val listOfTrees = values.map { if (it != null) TreeNode(it) else null }

        // Iterate through the list and assign left and right children
        for (i in listOfTrees.indices) {
            val currentNode = listOfTrees[i]

            // Skip if the current node is null
            if (currentNode == null) continue

            val leftChildIndex = 2 * i + 1
            val rightChildIndex = 2 * i + 2

            // Assign the left child if index is valid and the left child exists
            if (leftChildIndex < listOfTrees.size) {
                currentNode.left = listOfTrees[leftChildIndex]
            }

            // Assign the right child if index is valid and the right child exists
            if (rightChildIndex < listOfTrees.size) {
                currentNode.right = listOfTrees[rightChildIndex]
            }
        }

        // Return the root of the tree, which is the first non-null element in the list
        return listOfTrees[0]
    }
}