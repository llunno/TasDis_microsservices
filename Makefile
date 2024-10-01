# Run skaffold dev with necessary flags
skaffold-dev:
	skaffold dev --trigger=polling --watch-poll-interval=1000 --skip-tests=true --wait-for-connection=true

.PHONY: skaffold-dev