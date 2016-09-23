def can_build(p):
	return p == 'android'

def configure(env):
	if env['platform'] == 'android':
		env.android_add_java_dir("src")