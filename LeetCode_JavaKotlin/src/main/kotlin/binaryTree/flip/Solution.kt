package org.example.binaryTree.flip

class Solution {
    fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
        if (root1 == null || root2 == null) return false

        var currentLevel1 = listOf(root1)
        var currentLevel2: Map<Int, TreeNode?> = mapOf(Pair(root2.`val`, root2))

        while (currentLevel1.isNotEmpty()) {
            if (currentLevel1.size != currentLevel2.size) {
                return false
            }

            for (it in currentLevel1) {
                val eq = currentLevel2.getOrDefault(it.`val`, null)
                if (eq == null) {
                    return false
                }

                if (it.left?.`val` == eq.left?.`val` && it.right?.`val` == eq.right?.`val`) {
                    continue
                }

                if (it.left?.`val` == eq.right?.`val` && it.right?.`val` == eq.left?.`val`) {
                    continue
                }

                return false
            }

            currentLevel1 = currentLevel1.flatMap {
                listOfNotNull(it.left, it.right)
            }

            val pairs = ArrayList<Pair<Int, TreeNode?>>()
            for (it in currentLevel2.values) {
                listOfNotNull(it?.left, it?.right).forEach {
                    pairs.add(Pair(it.`val`, it))
                }
            }
            currentLevel2 = pairs.toMap().toMutableMap()

        }

        return false;
    }
}