class ListNode {
    public val: number
    next: ListNode | null
    random: ListNode | null

    constructor(val?: number, next?: ListNode, random?: ListNode) {
        this.val = (val === undefined ? 0 : val)
        this.next = (next === undefined ? null : next)
        this.random = (random === undefined ? null : random)
    }
}

function copyRandomList(head: ListNode | null): ListNode | null {
    if (head == null) {
        return null
    }
    extend(head)
    cloneRandom(head)
    return split(head)
};

function extend(head: ListNode) {
    let node: ListNode | null = head
    while (node != null) {
        let newNode = new ListNode(node.val)
        newNode.next = node.next
        node.next = newNode
        node = newNode.next
    }
}

function cloneRandom(head: ListNode) {
    let node: ListNode | null = head
    while (node != null) {
        let randomNode = node.random
        if (randomNode != null) {
            node!.next.random = randomNode.next
        }
        node = node.next!.next
    }
}

function split(head: ListNode): ListNode {
    let newHead: ListNode | null = null
    let tail: ListNode | null = null
    let node: ListNode | null = head
    while (node != null) {
        if (newHead == null) {
            newHead = node.next
            tail = node.next
        } else {
            tail!.next = node.next
            tail = tail!.next
        }
        node.next = node.next!.next
        node = node.next
    }
    return newHead!
}