var singleton = null

func _init():
    singleton = Globals.get_singleton("MySingleton")
    print("Hello has length: "+str(singleton.myFunction("Hello")))