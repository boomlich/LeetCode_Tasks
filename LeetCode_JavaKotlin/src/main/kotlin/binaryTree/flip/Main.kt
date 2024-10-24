package org.example.binaryTree.flip


fun main() {
    val s = Solution()
    val r1 = TreeNode(listOf(1,2,3,4,5,6,null,null,null,7,8))
    val r2 = TreeNode(listOf(1,3,2,null,6,4,5,null,null,null,null,8,7))

    val isFlipped = s.flipEquiv(r1, r2)

    println(isFlipped)
}