package org.example.binaryTree.flip


fun main() {
    val s = Solution()
    val r1 = TreeNode(listOf())
    val r2 = TreeNode(listOf())

    val isFlipped = s.flipEquiv(r1, r2)

    println(isFlipped)
}