.PHONY: dev css-once css-watch clean-dev clean-deploy deploy

########################
# Development targets #
######################

dev:
	@echo "Running development environment"
	clojure -A:fig:build

clean-dev:
	@echo "Cleaning dev target"
	rm -rf target/public

pom.xml:
	@echo "Generating pom file"
	clojure -Spom

css-once:
	@echo "Compiling CSS"
	./node_modules/.bin/postcss resources/css/tailwind.css -o resources/public/css/tailwind.css

css-watch:
	@echo "Watching CSS"
	./node_modules/.bin/postcss -w --verbose resources/css/tailwind.css -o resources/public/css/styles.css

#############################
# Deployment build targets #
###########################

clean-deploy:
	@echo "Cleaning deploy target"
	rm -rf deploy/public

deploy/public:
	@echo "Creating deploy/public"
	cp -r resources/public deploy/public

deploy/public/css/tailwind.css:
	@echo "Compiling CSS"
	./node_modules/.bin/postcss resources/css/tailwind.css -o deploy/public/css/tailwind.css

deploy: clean-deploy deploy/public deploy/public/css/tailwind.css
	@echo "Creating deployment build"
	clojure -A:fig:deploy

